/**
 * Copyright (c) 2002-2011 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package traversal.examples;

import static org.neo4j.trav.Filter.nodeFilter;
import static org.neo4j.trav.Predicates.propertyGreaterOrEqualTo;
import static org.neo4j.trav.Traversables.node;
import static org.neo4j.trav.Traversals.filter;
import static org.neo4j.trav.Traversals.loop;
import static org.neo4j.trav.Traversals.path;
import static org.neo4j.trav.Traversals.relationship;
import static org.neo4j.trav.Traversals.result;
import static org.neo4j.trav.Traversals.unique;
import static traversal.examples.FriendsOfFriendsTest.FoafTypes.FRIEND;

import org.junit.Test;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;

public class FriendsOfFriendsTest
{
    // <preformatted>
    enum FoafTypes implements RelationshipType { FRIEND }
    // </preformatted>

    /**
     * <pre>
     * (me)--FRIEND-->(friend)--FRIEND-->(FoaF); i.e. (s)--FRIEND-->(t)--FRIEND-->(t)
     * </pre>
     */
    @Test
    public void canTraverseMyFriendsAndTheirFriends() throws Exception
    {
        Node start = null;
        for ( Node node : node( start ).traverse( loop( relationship( FRIEND ), 1, 2 ) ).asNodes() )
        {
            // OK
        }
        // To exclude my friends friends who are also my friends:
        for ( Node node : node( start ).traverse( unique( loop( relationship( FRIEND ), 1, 2 ) ) ).asNodes() )
        {
            // OK
        }
    }

    /**
     * <pre>
     * (me)--FRIEND-->(friend{age >= 21})--FRIEND-->(FoaF) ; returns FoaFs
     * </pre>
     */
    @Test
    public void canInviteFriendsThatAreOldEnoughToGoToThePub() throws Exception
    {
        Node me = null;
        for ( Node friend : node( me ).traverse(
                path( result( filter( relationship( FRIEND ), nodeFilter( propertyGreaterOrEqualTo( "age", 21 ) ) ) ),
                        relationship( FRIEND ) ) ).asNodes() )
        {
            // OK
        }
    }
}
