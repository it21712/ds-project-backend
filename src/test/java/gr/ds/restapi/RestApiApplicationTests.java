package gr.ds.restapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class RestApiApplicationTests {

@Test
  void contextLoads(ApplicationContext context) {
    assertThat(context).isNotNull();
  }
}
