/**
 * @cond LICENSE
 * ######################################################################################
 * # LGPL License                                                                       #
 * #                                                                                    #
 * # This file is part of the RRD-AntLR4                                                #
 * # Copyright (c) 2016, Philipp Kraus (philipp.kraus@tu-clausthal.de)                  #
 * # This program is free software: you can redistribute it and/or modify               #
 * # it under the terms of the GNU Lesser General Public License as                     #
 * # published by the Free Software Foundation, either version 3 of the                 #
 * # License, or (at your option) any later version.                                    #
 * #                                                                                    #
 * # This program is distributed in the hope that it will be useful,                    #
 * # but WITHOUT ANY WARRANTY; without even the implied warranty of                     #
 * # MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the                      #
 * # GNU Lesser General Public License for more details.                                #
 * #                                                                                    #
 * # You should have received a copy of the GNU Lesser General Public License           #
 * # along with this program. If not, see http://www.gnu.org/licenses/                  #
 * ######################################################################################
 * @endcond
 */

package de.flashpixx.rrd_antlr4.antlr;

import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;


/**
 * represenation of a grammar rule
 */
public final class CGrammarRule implements IGrammarRule
{
    /**
     * ID of the rule
     */
    private final String m_id;
    /**
     * comment of the rule
     */
    private final String m_documentation;
    /**
     * elements
     */
    private final IGrammarCollection m_elements;

    /**
     * ctor
     *
     * @param p_id rule ID
     * @param p_documentation comment
     * @param p_elements grammar elements
     */
    public CGrammarRule( final String p_id, final String p_documentation, final IGrammarCollection p_elements )
    {
        m_id = p_id;
        m_documentation = p_documentation == null ? "" : p_documentation;
        m_elements = p_elements == null ? CGrammarEmptyCollection.INSTANCE : p_elements;
    }


    @Override
    public final String id()
    {
        return m_id;
    }

    @Override
    public final String documentation()
    {
        return m_documentation;
    }



    @Override
    public final int hashCode()
    {
        return this.id().hashCode();
    }

    @Override
    public final boolean equals( final Object p_object )
    {
        return this.hashCode() == p_object.hashCode();
    }

    @Override
    public final String toString()
    {
        return MessageFormat.format(
                "{0} -> {1} {2}",
                this.id(),
                StringUtils.join( m_elements, " | " ),
                m_documentation.isEmpty() ? "" : " // " + m_documentation
        ).trim();
    }

    @Override
    public final IGrammarCollection elements()
    {
        return m_elements;
    }
}
