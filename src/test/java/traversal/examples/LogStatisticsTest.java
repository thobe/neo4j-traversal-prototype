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

import static org.neo4j.trav.Selectors.endNode;
import static org.neo4j.trav.Selectors.nodeProperty;
import static org.neo4j.trav.Selectors.traversalSelector;
import static org.neo4j.trav.Traversables.node;
import static org.neo4j.trav.Traversals.path;
import static org.neo4j.trav.Traversals.relationship;
import static traversal.examples.LogStatisticsTest.DomainTypes.FROM_HOST;
import static traversal.examples.LogStatisticsTest.DomainTypes.PERFORMED_ON;
import static traversal.examples.LogStatisticsTest.DomainTypes.SUBNET;
import static traversal.examples.LogStatisticsTest.DomainTypes.TOOK_ACTION;

import java.util.Map;

import org.junit.Test;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.helpers.Triplet;
import org.neo4j.trav.Projection;

public class LogStatisticsTest
{
    // <preformatted>
    enum DomainTypes implements RelationshipType { TOOK_ACTION, PERFORMED_ON, FROM_HOST, SUBNET }
    // </preformatted>
    /**
     * <pre>
     * (source:user)--TOOK_ACTION-->(action)--PERFORMED_ON-->(domain)
     *                                  \--FROM_HOST-->(ip)--SUBNET-->(network)
     * </pre>
     */
    @Test
    public void canGatherInformationFromMultiplePartsOfATraversal() throws Exception
    {
        Node user = null;
        for ( Triplet<Node, String, String> actionNetworkDomain : node( user ).traverse( relationship( TOOK_ACTION ) ).asProjected(
                new ActionNetworkDomain() ) )
        {
            // OK
        }
        // Without custom projection:
        for ( Map<String, Object> actionNetworkDomain : node( user ).traverse( relationship( TOOK_ACTION ) ).asProjected(
                Projection.map(
                        endNode( "action" ),
                        traversalSelector( relationship( PERFORMED_ON ), nodeProperty( "domain" ) ),
                        traversalSelector( path( relationship( FROM_HOST ), relationship( SUBNET ) ),
                                nodeProperty( "subnet" ) ) ) ) )
        {
            // OK
        }
    }

    public class ActionNetworkDomain extends Projection<Triplet<Node, String, String>>
    {
        ActionNetworkDomain()
        {
            // <preformatted>
            super( endNode( "action" ),
                   traversalSelector( relationship( PERFORMED_ON ), nodeProperty( "domain" ) ),
                   traversalSelector( path( relationship( FROM_HOST ), relationship( SUBNET ) ), nodeProperty( "subnet" ) ) );
            // </preformatted>
        }

        @Override
        protected Triplet<Node, String, String> project( Map<String, Object> selected )
        {
            return Triplet.of( (Node) selected.get( "action" ), (String) selected.get( "domain" ),
                    (String) selected.get( "subnet" ) );
        }
    }
}
