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

import java.util.Map;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.RelationshipType;

public class Traversals
{
    public static Traversal relationship( RelationshipType type )
    {
        return relationship( type, Direction.BOTH );
    }

    public static Traversal relationship( RelationshipType type, Direction both )
    {
        return null;
    }

    public static Traversal relationship( Direction direction )
    {
        return null;
    }

    public static Traversal path( Traversal first, Traversal second, Traversal... more )
    {
        return null;
    }

    public static Traversal branch( Traversal option1, Traversal option2, Traversal... options )
    {
        return null;
    }

    public static Traversal filter( Traversal traversal, Filter filter, Filter... more )
    {
        if ( more != null && more.length > 0 )
        {
            filter = Filter.allOf( filter, more );
        }
        return null;
    }

    public static Traversal unique( Traversal traversal )
    {
        return null;
    }

    public static Traversal loop( Traversal step, int min, int max )
    {
        return null;
    }

    public static Traversal loopUntil( Traversal step, Predicate goal, int max )
    {
        return null;
    }

    /**
     * Include the result of this step in the result set.
     */
    public static Traversal result( Traversal traversal )
    {
        return null;
    }

    public static Traversal dynamicRelationship( Selector type )
    {
        return dynamicRelationship( type, Direction.BOTH );
    }

    public static Traversal dynamicRelationship( Selector type, Direction direction )
    {
        return null;
    }

    public static Traversal dynamicRelationship( Selector type, Map<Object, RelationshipType> types )
    {
        return dynamicRelationship( type, types, Direction.BOTH );
    }

    public static Traversal dynamicRelationship( Selector type, Map<Object, RelationshipType> types, Direction direction )
    {
        return null;
    }

    public static Traversal dynamicRelationshipDirection( Selector direction, Map<Object, Direction> directions )
    {
        return null;
    }

    public static Traversal dynamicRelationshipDirection( RelationshipType type, Selector direction,
            Map<Object, Direction> directions )
    {
        return null;
    }

    public static Traversal dynamicRelationship( Selector type, Selector direction, Map<Object, Direction> directions )
    {
        return null;
    }

    public static Traversal dynamicRelationship( Selector type, Map<Object, RelationshipType> types,
            Selector direction, Map<Object, Direction> directions )
    {
        return null;
    }

    private Traversals()
    {
        // Just contains static factory methods
    }
}
