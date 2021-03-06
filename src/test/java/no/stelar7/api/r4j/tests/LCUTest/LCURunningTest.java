package no.stelar7.api.r4j.tests.LCUTest;

import com.google.gson.JsonObject;
import no.stelar7.api.r4j.impl.lol.lcu.*;
import org.junit.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class LCURunningTest
{
    @Test
    @Ignore
    public void testRunning()
    {
        Assert.assertNotNull("Unable to fecth connection string from league client... Is it running?", LCUConnection.getConnectionString());
    }
    
    
    @Test
    @Ignore
    public void testLogin()
    {
        LCUApi.login("myusername", "mypassword");
    }
    
    @Test
    @Ignore
    public void testReplay()
    {
        LCUApi.downloadReplay(3042295790L);
        LCUApi.spectateGame(3042295790L);
        System.out.println(LCUApi.getReplaySavePath());
    }
    
    @Test
    @Ignore
    public void testbyId()
    {
        JsonObject summoner = LCUApi.getSummoner(19613950);
        System.out.println();
    }
    
    @Test
    @Ignore
    public void testCustomURL()
    {
        Object obj2 = LCUApi.customUrl("lol-clubs/v1/clubs/e1c2f384-9447-4aac-b7d6-56604a50f2d4", "{\"tag\":\"\uD83D\uDC36\"}", "GET");
        System.out.println(obj2);
    }
    
    @Test
    @Ignore
    public void testStartInfiniteChampSelect()
    {
        //LCUApi.createLobby()
    }
    
    @Test
    @Ignore
    public void testLogAllEvents() throws InterruptedException
    {
        Thread th = new Thread(() -> {
            try
            {
                LCUSocketReader socket = LCUApi.createWebSocket();
                socket.connect();
                
                for (String key : LCUApi.getWebsocketEvents())
                {
                    // ignore the "catch-all" event
                    if (key.equalsIgnoreCase("OnJsonApiEvent"))
                    {
                        continue;
                    }
                    
                    socket.subscribe(key, k -> {
                        try
                        {
                            Files.createDirectories(Paths.get("D:\\lcu"));
                            Files.write(Paths.get("D:\\lcu", key + ".json"), k.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
                        } catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                    });
                }
                
                while (socket.isConnected())
                {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }, "LCU Socket thread");
        
        th.start();
        th.join();
    }
    
    
    @Test
    @Ignore
    public void testCreateSocket() throws InterruptedException
    {
        Thread th = new Thread(() -> {
            try
            {
                LCUSocketReader socket = LCUApi.createWebSocket();
                socket.connect();
                socket.subscribe("OnJsonApiEvent", System.out::println);
                while (socket.isConnected())
                {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }, "LCU Socket thread");
        
        th.start();
        th.join();
    }
    
    
    @Test
    @Ignore
    public void testLogChampselectSession() throws InterruptedException
    {
        Thread th = new Thread(() -> {
            try
            {
                LCUSocketReader socket = LCUApi.createWebSocket();
                socket.connect();
                socket.subscribe("OnJsonApiEvent_lol-champ-select_v1_session", v -> {
                    try
                    {
                        Files.write(Paths.get("D:\\lcu", "session.json"), v.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                });
                
                while (socket.isConnected())
                {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }, "LCU Socket thread");
        
        th.start();
        th.join();
    }
    
}
