package org.basseur.adventofcode.advent2018;

import org.basseur.adventofcode.advent2018.service.AdventOfCodeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;
import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AdventOfCodeController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class AdventOfCodeControllerTest {

    private String baseUrl = "/api/adventOfCode";

    private MediaType contentType = new MediaType("application", "hal+json", Charset.forName("UTF-8"));

    private String day1 = "1";
    private String part1 = "1";
    private String resultDay1Part1 = "Part 1 - Frequency: 599";

    @Autowired
    private MockMvc mvc;

    @MockBean
    AdventOfCodeService adventOfCodeService;

    @Before
    public void setup() {

        Mockito.when(adventOfCodeService.getResultsForASpecificDayAndPuzzlePart(day1, part1))
                .thenReturn(resultDay1Part1);
    }

    @Test
    public void testGetResultForASpecificDayAndPuzzlePart()throws Exception {

        mvc.perform(get(baseUrl + "?day=" + day1 + "&part=" + part1)
                .contentType(contentType))
                .andExpect(status().isOk())
                .andExpect(jsonPath("content", is(resultDay1Part1)))
                .andExpect(jsonPath("$._links.self.href", is("http://localhost:8080" + baseUrl + "?day=" + day1 + "&part=" + part1)))
                .andDo(document("getAppointmentsForADateForAnEmployee",
                        preprocessResponse(prettyPrint()),
                        responseFields(getResultForASpecificDayAndPuzzlePart("")))
                );

    }

    private ArrayList<FieldDescriptor> getResultForASpecificDayAndPuzzlePart(String path) {
        String pathString;
        if (path.isEmpty()) {
            pathString = "";
        } else pathString = path;

        ArrayList<FieldDescriptor> fieldDescriptorList = new ArrayList<>();
        fieldDescriptorList.add(fieldWithPath(pathString + "content")
                .description("Result of the Puzzle for a specific day and part of the AdventOfCode calendar"));
        fieldDescriptorList.add(fieldWithPath(pathString + "_links.self.href")
                .description("Self link to the query for the specific solution for a day and part"));

        return fieldDescriptorList;
    }
}