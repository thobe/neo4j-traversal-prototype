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

import static org.junit.Assert.fail;
import static org.neo4j.trav.Traversables.node;
import static org.neo4j.trav.Traversals.branch;
import static org.neo4j.trav.Traversals.path;
import static org.neo4j.trav.Traversals.relationship;
import static traversal.examples.SimplePathTest.SimplePathTypes.A;
import static traversal.examples.SimplePathTest.SimplePathTypes.B;
import static traversal.examples.SimplePathTest.SimplePathTypes.C;
import static traversal.examples.SimplePathTest.SimplePathTypes.D;
import static traversal.examples.SimplePathTest.SimplePathTypes.E;
import static traversal.examples.SimplePathTest.SimplePathTypes.F;

import org.junit.Test;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.trav.Traversables;
import org.neo4j.trav.Traversals;

public class SimplePathTest
{
    // <preformatted>
    enum SimplePathTypes implements RelationshipType { A, B, C, D, E, F }
    // </preformatted>

    /**
     * <pre>
     * (s)--A-->(t)
     * </pre>
     */
    @Test
    public void canCreateOneStepPath() throws Exception
    {
        Node start = null;
        for ( Node node : Traversables.node( start ).traverse( Traversals.relationship( SimplePathTypes.A ) ).asNodes() )
        {
            // OK
        }
        // Or with static imports
        for ( Node node : node( start ).traverse( relationship( A ) ).asNodes() )
        {
            // OK
        }
    }

    /**
     * <pre>
     * (s)--A-->(t)
     *   |      ^
     *   \--B--/
     * </pre>
     */
    @Test
    public void canTraverseOneStepPathOfOneOutOfTwoTypes() throws Exception
    {
        Node start = null;
        for ( Node node : node( start ).traverse( branch( relationship( A ), relationship( B ) ) ).asNodes() )
        {
            // OK
        }
    }

    /**
     * <pre>
     * (s)--A-->()--B-->(t)
     * </pre>
     */
    @Test
    public void canTraverseTwoStepPathOfDifferentTypes() throws Exception
    {
        Node start = null;
        for ( Node node : node( start ).traverse( path( relationship( A ), relationship( B ) ) ).asNodes() )
        {
            // OK
        }
    }

    /**
     * <pre>
     * (s)--A-->()--C-->(t)
     *   |      ^
     *   \--B--/
     * </pre>
     */
    @Test
    public void canTraverseOneStepOfOneOutOfTwoTypesThenAnotherType() throws Exception
    {
        Node start = null;
        for ( Node node : node( start ).traverse(
                path( branch( relationship( A ), relationship( B ) ), relationship( C ) ) ).asNodes() )
        {
            // OK
        }
    }

    /**
     * <pre>
     * (s)----A---->()----D---->()--F-->(t)
     *   |                      ^
     *   \--B-->()--C-->()--E--/
     * </pre>
     */
    @Test
    public void canTraverseDifferentPathsOfDifferentLengthsThenJoinForAnotherStep() throws Exception
    {
        Node start = null;
        for ( Node node : node( start ).traverse(
                path( branch( path( relationship( A ), relationship( D ) ),
                        path( relationship( B ), relationship( C ), relationship( E ) ) ), relationship( F ) ) ).asNodes() )
        {
            // OK
        }
        fail( "canTraverseSomethingSomething not implemented" );
    }
}
