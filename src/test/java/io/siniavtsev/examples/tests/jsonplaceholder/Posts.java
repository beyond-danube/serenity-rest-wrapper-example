package io.siniavtsev.examples.tests.jsonplaceholder;

import com.typicode.jsonplaceholder.model.Post;
import net.serenitybdd.core.Serenity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class Posts extends JsonPlaceholderBaseTest{

    @Test
    void getAllPosts() {
        restSteps.setEndpoint("posts");
        var result = restSteps.getResponseObjectsList(Post.class);

        Serenity.reportThat("Check there are exactly 100 posts in total", () -> assertThat(result.size()).isEqualTo(100));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 7, 2})
    void getPostByID(Integer id) {
        restSteps.setEndpoint("posts/" + id);
        var result = restSteps.getResponseObject(Post.class);

        Serenity.reportThat("Check retured Post has expected ID: " + id, () -> assertThat(result.getId()).isEqualTo(id));
    }

}
