package pl.openx.project.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.math.BigDecimal;

public class BigDecimalAdapter implements JsonDeserializer<BigDecimal> {

    @Override
    public BigDecimal deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return new BigDecimal(jsonElement.getAsJsonPrimitive().getAsString());
    }
}