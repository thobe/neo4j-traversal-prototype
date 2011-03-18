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

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.PropertyContainer;
import org.neo4j.graphdb.Relationship;

public abstract class Projection<T>
{
    public Projection( Selector selector, Selector... more )
    {

    }

    public static Projection<Map<String, Node>> nodeMap( Selector selector, Selector... more )
    {
        return new Projection<Map<String, Node>>( selector, more )
        {
            @Override
            protected Map<String, Node> project( Map<String, Object> selected )
            {
                // TODO Auto-generated method stub
                return null;
            }
        };
    }

    public static Projection<Map<String, Relationship>> relationshipMap( Selector selector, Selector... more )
    {
        return null;
    }

    public static Projection<Map<String, PropertyContainer>> entityMap( Selector selector, Selector... more )
    {
        return null;
    }

    public static Projection<Map<String, Object>> propertyMap( Selector selector, Selector... more )
    {
        return null;
    }

    public static Projection<Map<String, Object>> map( Selector selector, Selector... more )
    {
        return null;
    }

    protected abstract T project( Map<String, Object> selected );
}
