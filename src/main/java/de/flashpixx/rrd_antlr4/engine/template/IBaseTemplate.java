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

import com.aol.cyclops.sequence.SequenceM;
import de.flashpixx.rrd_antlr4.CCommon;
import org.apache.commons.io.FileUtils;

import java.io.File;
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
    protected final void copy( final String p_templatefile, final Path p_output ) throws IOException, URISyntaxException
    {
        final Path l_target = Paths.get( p_output.toString(), p_templatefile );
        Files.createDirectories( l_target.getParent() );
        Files.copy(
                CCommon.getResourceURL( MessageFormat.format( "{0}{1}{2}{3}", "template/", m_name, "/", p_templatefile ) ).openStream(),
                l_target,
                StandardCopyOption.REPLACE_EXISTING
        );
    }

    /**
     * replaces the string within the file
     *
     * @param p_file file
     * @param p_replacepair string tupels for replacing
     */
    protected final void replace( final File p_file, final String... p_replacepair ) throws IOException
    {
        if ( ( p_replacepair == null ) || ( p_replacepair.length % 2 != 0 ) )
            throw new IllegalArgumentException( CCommon.getLanguageString( IBaseTemplate.class, "replaceerror" ) );

        final CStringReplacing l_content = new CStringReplacing( FileUtils.readFileToString( p_file ) );
        SequenceM.rangeLong( 0, p_replacepair.length )
                 .sliding( 2, 2 )
                 .forEach( i -> l_content.replaceAll( p_replacepair[i.get( 0 ).intValue()], p_replacepair[i.get( 1 ).intValue()] ) );
        FileUtils.writeStringToFile( p_file, l_content.get() );
    }


    /**
     * class for replacing string content
     */
    private static final class CStringReplacing
    {
        /**
         * string data
         */
        private String m_data;

        /**
         * ctor
         *
         * @param p_data input data
         */
        public CStringReplacing( final String p_data )
        {
            m_data = p_data;
        }

        /**
         * replaces the content
         *
         * @param p_source source
         * @param p_target target
         */
        public final void replaceAll( final String p_source, final String p_target )
        {
            m_data = m_data.replaceAll( p_source, p_target );
        }

        /**
         * returns the data
         *
         * @return string
         */
        public final String get()
        {
            return m_data;
        }

        @Override
        public final int hashCode()
        {
            return m_data.hashCode();
        }

        @Override
        public final boolean equals( final Object p_object )
        {
            return m_data.hashCode() == p_object.hashCode();
        }

        @Override
        public final String toString()
        {
            return m_data;
        }
    }
}
