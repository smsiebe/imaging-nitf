/*
 * Copyright (c) Codice Foundation
 *
 * This is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser
 * General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details. A copy of the GNU Lesser General Public License
 * is distributed along with this program and can be found at
 * <http://www.gnu.org/licenses/lgpl.html>.
 *
 */
package org.codice.imaging.nitf.core;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.text.ParseException;

/**
    Factory class for NitfFile instances.
 */
public final class NitfFileFactory {

    /**
        Private constructor.
        <p>
        This class is not intended to be instantiated.
    */
    private NitfFileFactory() {
    }

//    /**
//        Parse NITF file headers out of an InputStream.
//        <p>
//        This only extracts the headers from the main file, and the attached segment headers. The actual
//        data segments are skipped over.
//        <p>
//        Because this takes an InputStream (which is not seekable), it cannot work on NITF files that use
//        "streaming mode", where the sizes are only provided at the end of the file. An exception will be
//        thrown in this case.
//
//        @param nitfInputStream the input stream to parse over.
//        @return NitfFile structure corresponding to the input stream.
//        @throws ParseException on detecting an invalid file or other parse error.
//    */
//    public static Nitf parseHeadersOnly(final InputStream nitfInputStream) throws ParseException {
//        NitfReader reader = new InputStreamReader(new BufferedInputStream(nitfInputStream));
//        return NitfFileParser.parse(reader, EnumSet.noneOf(ParseOption.class));
//    }

//    /**
//        Parse NITF file headers out of a File.
//        <p>
//        This only extracts the headers from the main file, and the attached segment headers. The actual
//        data segments are skipped over.
//        <p>
//        This takes a File, so it can handle the "streaming mode" layout.
//
//        @param nitfFile the file to parse.
//        @return NitfFile structure corresponding to the input stream.
//        @throws ParseException if the file is not present, for an invalid file or other parse error.
//    */
//    public static Nitf parseHeadersOnly(final File nitfFile) throws ParseException {
//        NitfReader reader = new FileReader(nitfFile);
//        return NitfFileParser.parse(reader, EnumSet.noneOf(ParseOption.class));
//    }

//    /**
//        Parse NITF file headers and selected data out of an InputStream.
//        <p>
//        This extracts the headers and any selected data segments. Any segments that are not selected will be skipped over.
//        <p>
//        Because this takes an InputStream (which is not seekable), it cannot work on NITF files that use
//        "streaming mode", where the sizes are only provided at the end of the file. An exception will be
//        thrown in this case.
//
//        @param nitfInputStream the input stream to parse over.
//        @param parseOptions the data segments to extract.
//        @return NitfFile structure corresponding to the input stream.
//        @throws ParseException on detecting an invalid file or other parse error.
//    */
//    public static Nitf parseSelectedDataSegments(final InputStream nitfInputStream, final Set<ParseOption> parseOptions) throws ParseException {
//        NitfReader reader = new InputStreamReader(new BufferedInputStream(nitfInputStream));
//        return NitfFileParser.parse(reader, parseOptions);
//    }

//    /**
//        Parse NITF file headers and selected data from a File.
//        <p>
//        This extracts the headers and any selected data segments. Any segments that are not selected will be skipped over.
//        <p>
//        This takes a File, so it can handle the "streaming mode" layout
//
//        @param nitfFile the file to parse.
//        @param parseOptions the data segments to extract.
//        @return NitfFile structure corresponding to the input stream.
//        @throws ParseException if the file is not present, for an invalid file or other parse error.
//    */
//    public static Nitf parseSelectedDataSegments(final File nitfFile, final Set<ParseOption> parseOptions) throws ParseException {
//        NitfReader reader = new FileReader(nitfFile);
//        return NitfFileParser.parse(reader, parseOptions);
//    }

    /**
     * Parse an input stream using the specified strategy.
     *
     * @param nitfInputStream the input stream to parse over.
     * @param parseStrategy the strategy to use during parsing
     * @throws ParseException for problems found during parsing
    */
    public static void parse(final InputStream nitfInputStream, final NitfParseStrategy parseStrategy) throws ParseException {
        NitfReader reader = new InputStreamReader(new BufferedInputStream(nitfInputStream));
        NitfFileParser.parse(reader, parseStrategy);
    }

    /**
     * Parse a File using the specified strategy.
     *
     * @param nitfFile the file to parse over.
     * @param parseStrategy the strategy to use during parsing.
     * @throws ParseException for problems found during parsing
    */
    public static void parse(final File nitfFile, final NitfParseStrategy parseStrategy) throws ParseException {
        NitfReader reader = new FileReader(nitfFile);
        NitfFileParser.parse(reader, parseStrategy);
    }
}
