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

/**
 * any grammar element
 */
public interface IGrammarElement
{
    /**
     * returns the cardinality
     *
     * @return cardinality
     */
    ECardinality cardinality();

    /**
     * changes the cardinality
     *
     * @param p_cardinality cardinality value
     * @return self reference
     */
    IGrammarElement cardinality( final ECardinality p_cardinality );

    /**
     * enum define cardinalities
     */
    enum ECardinality
    {
        NONE( "" ),
        OPTIONAL( "?" ),
        ZEROORMORE( "*" ),
        ONEORMORE( "+" );

        /**
         * string definition
         */
        private String m_text;

        ECardinality( final String p_text )
        {
            m_text = p_text;
        }


        @Override
        public final String toString()
        {
            return m_text;
        }
    }

}
