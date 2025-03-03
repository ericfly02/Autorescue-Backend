package cat.gencat.autorescue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotNull;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "spring.main.allow-bean-definition-overriding=true" ,"spring.profiles.include=loc"})
@AutoConfigureMockMvc(addFilters = false)
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
public abstract class CommonControllerTest {

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected MockMvc mockMvc;


    protected MvcResult execute(@NotNull MockHttpServletRequestBuilder request, String object) throws Exception {
        return mockMvc.perform(request.contentType(MediaType.APPLICATION_JSON_VALUE).content(object))
                .andReturn();
    }

    protected void assertSuccess(@NotNull MvcResult result) throws Exception {
        String content = result.getResponse().getContentAsString();
        JsonNode jsonResponse = objectMapper.readTree(content);
        Assert.assertTrue(jsonResponse.get("success").asBoolean());
    }

    protected void assertFail(@NotNull MvcResult result) throws Exception {
        String content = result.getResponse().getContentAsString();
        JsonNode jsonResponse = objectMapper.readTree(content);
        Assert.assertFalse(jsonResponse.get("success").asBoolean());
    }








}
