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

package de.flashpixx.rrd_antlr4.engine.template;

import de.flashpixx.rrd_antlr4.antlr.IGrammarComplexElement;

import java.nio.file.Path;


/**
 * template for LaTeX export
 */
public class CLaTeX extends IBaseTemplate
{

    /**
     * ctor
     *
     * @param p_name template name
     */
    public CLaTeX( final String p_name )
    {
        super( p_name );
    }

    @Override
    public final void preprocess( final Path p_output )
    {

    }

    @Override
    public final void postprocess( final Path p_output )
    {

    }

    @Override
    public final void grammar( final IGrammarComplexElement p_grammar )
    {

    }

    @Override
    public final void element( final IGrammarComplexElement p_grammar, final IGrammarComplexElement p_element )
    {

    }

}
