package hei.school.photoTraining.endpoint.rest.controller;

import static hei.school.photoTraining.endpoint.rest.controller.health.PingController.OK;
import static org.junit.jupiter.api.Assertions.assertEquals;

import hei.school.photoTraining.PojaGenerated;
import hei.school.photoTraining.conf.FacadeIT;
import hei.school.photoTraining.endpoint.rest.controller.health.HealthDbController;
import hei.school.photoTraining.endpoint.rest.controller.health.PingController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@PojaGenerated
class HealthControllerIT extends FacadeIT {

  @Autowired PingController pingController;
  @Autowired HealthDbController healthDbController;

  @Test
  void ping() {
    assertEquals("pong", pingController.ping());
  }

  @Test
  void can_read_from_dummy_table() {
    var responseEntity = healthDbController.dummyTable_should_not_be_empty();
    assertEquals(OK, responseEntity);
  }
}
