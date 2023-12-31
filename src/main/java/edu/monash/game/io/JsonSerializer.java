package edu.monash.game.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import edu.monash.game.Game;
import edu.monash.game.GameState;

import java.io.File;
import java.io.IOException;

/**
 * A serializer for JSON files.
 */
public class JsonSerializer implements Serializer {

    @Override
    public String getSupportedFileExtension() {
        return "json";
    }

    /**
     * Serializes a game state to a JSON file.
     *
     * @param filepath The path to the file.
     */
    @Override
    public void serialize(Game game, String filepath) {
        GameState gameState = new GameState(game.getBoard(), game.getMoves());

        // Create an object mapper.
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Serialize the game state to a file.
        try {
            File file = new File(filepath);
            objectMapper.writeValue(file, gameState);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
