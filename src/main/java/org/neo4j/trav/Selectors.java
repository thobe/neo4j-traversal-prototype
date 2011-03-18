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
import org.neo4j.graphdb.Relationship;

public class Selectors
{
    public static Selector node( String name, int position )
    {
        return entity( name, node( position ) );
    }

    public static EntitySelector<Node> node( int position )
    {
        return null;
    }

    public static Selector relationship( String name, int position )
    {
        return entity( name, relationship( position ) );
    }

    public static EntitySelector<Relationship> relationship( int position )
    {
        return null;
    }

    public static Selector endNode( String name )
    {
        return entity( name, endNode() );
    }

    public static EntitySelector<Node> endNode()
    {
        return null;
    }

    public static Selector lastRelationship( String name )
    {
        return entity( name, lastRelationship() );
    }

    public static EntitySelector<Relationship> lastRelationship()
    {
        return null;
    }

    public static Selector nodeProperty( String key )
    {
        return nodeProperty( key, key );
    }

    public static Selector nodeProperty( String name, String key )
    {
        return property( name, endNode(), key );
    }

    public static Selector nodeProperty( String key, Object defaultValue )
    {
        return nodeProperty( key, key, defaultValue );
    }

    public static Selector nodeProperty( String name, String key, Object defaultValue )
    {
        return property( name, endNode(), key, defaultValue );
    }

    public static Selector nodeProperty( int position, String key )
    {
        return nodeProperty( key, position, key );
    }

    public static Selector nodeProperty( String name, int position, String key )
    {
        return property( name, node( position ), key );
    }

    public static Selector nodeProperty( int position, String key, Object defaultValue )
    {
        return nodeProperty( key, position, key, defaultValue );
    }

    public static Selector nodeProperty( String name, int position, String key, Object defaultValue )
    {
        return property( name, node( position ), key, defaultValue );
    }

    public static Selector relationshipProperty( String key )
    {
        return relationshipProperty( key, key );
    }

    public static Selector relationshipProperty( String name, String key )
    {
        return property( name, lastRelationship(), key );
    }

    public static Selector relationshipProperty( String key, Object defaultValue )
    {
        return relationshipProperty( key, key, defaultValue );
    }

    public static Selector relationshipProperty( String name, String key, Object defaultValue )
    {
        return property( name, lastRelationship(), key, defaultValue );
    }

    public static Selector relationshipProperty( int position, String key )
    {
        return relationshipProperty( key, position, key );
    }

    public static Selector relationshipProperty( String name, int position, String key )
    {
        return property( name, relationship( position ), key );
    }

    public static Selector relationshipProperty( int position, String key, Object defaultValue )
    {
        return relationshipProperty( key, position, key, defaultValue );
    }

    public static Selector relationshipProperty( String name, int position, String key, Object defaultValue )
    {
        return property( name, relationship( position ), key, defaultValue );
    }

    public static Selector traversalSelector( int position, Traversal traversal, Selector subselect )
    {
        return traversalSelector( node( position ), traversal, subselect );
    }

    public static Selector traversalSelector( Traversal traversal, Selector subselect )
    {
        return traversalSelector( endNode(), traversal, subselect );
    }

    public static Selector traversalSelector( EntitySelector<?> source, Traversal traversal, Selector subselect )
    {
        return null;
    }

    public static Selector lastRelationshipType( String name )
    {
        return type( name, lastRelationship() );
    }

    public static Selector relationshipType( String name, int position )
    {
        return type( name, relationship( position ) );
    }

    private static Selector type( String name, EntitySelector<Relationship> relationship )
    {
        // TODO Auto-generated method stub
        return null;
    }

    private static Selector entity( String name, EntitySelector<?> node )
    {
        // TODO Auto-generated method stub
        return null;
    }

    private static Selector property( String name, EntitySelector<?> selector, String key )
    {
        // TODO Auto-generated method stub
        return null;
    }

    private static Selector property( String name, EntitySelector<?> selector, String key, Object defaultValue )
    {
        // TODO Auto-generated method stub
        return null;
    }

    private Selectors()
    {
        // Just contains static factory methods
    }
}
