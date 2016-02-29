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

import de.flashpixx.rrd_antlr4.CCommon;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.MessageFormat;


/**
 * base implementation
 */
public abstract class IBaseTemplate implements ITemplate
{

    /**
     * template name
     */
    private final String m_name;

    /**
     * ctor
     *
     * @param p_name template name
     */
    public IBaseTemplate( final String p_name )
    {
        m_name = p_name.trim().toLowerCase();
    }

    @Override
    public final String name()
    {
        return m_name;
    }

    /**
     * copies files from the template directory of the template
     * to the output directory
     *
     * @param p_templatefile file within the template directory
     * @param p_output output directory
     * @throws IOException on IO error
     * @throws URISyntaxException on URL syntax error
     */
    public final void copy( final String p_templatefile, final Path p_output ) throws IOException, URISyntaxException
    {
        final Path l_target = Paths.get( p_output.toString(), p_templatefile );
        Files.createDirectories( l_target.getParent() );
        Files.copy(
                CCommon.getResourceURL( MessageFormat.format( "{0}{1}{2}{3}", "template/", m_name, "/", p_templatefile ) ).openStream(),
                l_target,
                StandardCopyOption.REPLACE_EXISTING
        );
    }

}
