package ru.project.parking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.project.parking.dto.StatusDTO;
import ru.project.parking.repository.ParkingRepository;
import ru.project.parking.service.PanelService;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PanelControllerTest {
    private final ObjectMapper om = new ObjectMapper();
    @Mock
    private ParkingRepository parkingRepository;
    @Autowired
    private MockMvc mockMvc;

    private long amountOfFreeSpaces = 50;
    private long amountOfTakenSpaces = 0;
    private long amountOfParkingSpaces = 50;

    @BeforeTestClass
    public void setUp() {
        Mockito.doReturn(amountOfFreeSpaces).when(parkingRepository.findFreeParkingPlaces());
    }

    @Test
    public void testFindFreeParkingPlaces() throws Exception {
        MvcResult request = mockMvc.perform(get("/api/status"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String result = request.getResponse().getContentAsString();
        StatusDTO statusDTO = om.readValue(result, StatusDTO.class);
        assertAll(
                () -> assertEquals(statusDTO.getAmountOfFreeSpaces(), amountOfFreeSpaces),
                () -> assertEquals(statusDTO.getAmountOfTakenSpaces(), amountOfTakenSpaces),
                () -> assertEquals(statusDTO.getAmountOfParkingSpaces(), amountOfParkingSpaces)
                );
    }

}
