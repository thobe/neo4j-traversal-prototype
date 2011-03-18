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

public class Predicates
{
    public static Predicate propertyExists( String key )
    {
        return null;
    }

    public static Predicate propertyEquals( String key, Object value )
    {
        return null;
    }

    public static Predicate propertyEqualsIgnoreCase( String key, String value )
    {
        return null;
    }

    public static Predicate propertyStartsWith( String key, String prefix )
    {
        return null;
    }

    public static Predicate propertyEndsWith( String key, String suffix )
    {
        return null;
    }

    public static Predicate propertyStartsWithIgnoreCase( String key, String prefix )
    {
        return null;
    }

    public static Predicate propertyEndsWithIgnoreCase( String key, String suffix )
    {
        return null;
    }

    public static Predicate propertyLessThan( String key, long roof )
    {
        return null;
    }

    public static Predicate propertyLessOrEqualTo( String key, long roof )
    {
        return null;
    }

    public static Predicate propertyLessThan( String key, double roof )
    {
        return null;
    }

    public static Predicate propertyLessOrEqualTo( String key, double roof )
    {
        return null;
    }

    public static Predicate propertyGreaterThan( String key, long floor )
    {
        return null;
    }

    public static Predicate propertyGreaterOrEqualTo( String key, long floor )
    {
        return null;
    }

    public static Predicate propertyGreaterThan( String key, double floor )
    {
        return null;
    }

    public static Predicate propertyGreaterOrEqualTo( String key, double floor )
    {
        return null;
    }

    public static Predicate combine( Predicate predicate, Predicate... more )
    {
        return null;
    }

    private Predicates()
    {
        // Just contains static factory methods
    }
}
