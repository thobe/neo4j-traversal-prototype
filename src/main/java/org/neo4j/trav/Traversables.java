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
package org.neo4j.trav;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Path;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.index.IndexHits;

/**
 * Transitional static methods until the core types implement
 * {@link Traversable}.
 *
 * @author Tobias Ivarsson
 * @author Mattias Persson
 */
public class Traversables
{
    public static Traversable node( Node node )
    {
        return null;
    }

    public static Traversable relationship( Relationship relationship )
    {
        return null;
    }

    public static Traversable path( Path path )
    {
        return null;
    }

    public static Traversable index( IndexHits<?> index )
    {
        return null;
    }

    private Traversables()
    {
        // Just contains static factory methods
    }
}
