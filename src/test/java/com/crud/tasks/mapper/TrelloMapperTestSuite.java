package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {

    @InjectMocks
    private TrelloMapper mapper;

    @Test
    public void testMapToBoards() {
        //Given
        List<TrelloListDto> trelloListsDto = Arrays.asList(new TrelloListDto("1", "Name1", true), new TrelloListDto("2", "Name2", false));
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("1", "Name", trelloListsDto);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("2", "Name2", trelloListsDto);
        List<TrelloBoardDto> trelloBoardList = Arrays.asList(trelloBoardDto1, trelloBoardDto2);
        //When
        List<TrelloBoard> mappedTrelloBoard = mapper.mapToBoards(trelloBoardList);
        //Then
        Assert.assertEquals(2, mappedTrelloBoard.size());
        Assert.assertEquals("1", mappedTrelloBoard.get(0).getId());
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        List<TrelloList> trelloLists = Arrays.asList(new TrelloList("1", "Name1", true), new TrelloList("2", "Name2", false));
        TrelloBoard trelloBoard1 = new TrelloBoard("1", "Name1", trelloLists);
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "Name2", trelloLists);
        List<TrelloBoard> trelloBoardList = Arrays.asList(trelloBoard1, trelloBoard2);
        //When
        List<TrelloBoardDto> mappedTrelloBoardDto = mapper.mapToBoardsDto(trelloBoardList);
        //Then
        Assert.assertEquals(2, trelloBoardList.size());
        Assert.assertEquals("Name2", mappedTrelloBoardDto.get(1).getName());
    }

    @Test
    public void testMapToList() {
        //Given
        List<TrelloListDto> trelloListDtos = Arrays.asList(new TrelloListDto("1", "Name1", false), new TrelloListDto("2", "Name2", false));
        //When
        List<TrelloList> mappedTrelloList = mapper.mapToLists(trelloListDtos);
        //Then
        Assert.assertEquals(2, mappedTrelloList.size());
    }

    @Test
    public void testMapToListDto() {
        //Given
        List<TrelloList> trelloLists = Arrays.asList(new TrelloList("1", "Name1", true),
                new TrelloList("2", "Name2", false));
        //When
        List<TrelloListDto> mappedListDto = mapper.mapToListsDto(trelloLists);
        //Then
        Assert.assertEquals(2, mappedListDto.size());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Name", "Descripton", "123", "left");
        //When
        TrelloCardDto mappedTrelloCardDto = mapper.mapToCardDto(trelloCard);
        //Then
        Assert.assertEquals("123", mappedTrelloCardDto.getPos());
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Name1", "Description1", "List1", "center");
        //When
        TrelloCard mappedTrelloCard = mapper.mapToCard(trelloCardDto);
        //Then
        Assert.assertEquals("Name1", mappedTrelloCard.getName());
    }
}