package com.ecommerce.ecommercestore.shared.state.serializer;

import com.ecommerce.ecommercestore.shared.state.enums.State;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class StateSerializer extends StdSerializer<State> {
    public StateSerializer(){
        this(null);
    }
    public StateSerializer(Class<State> t){
        super(t);
    }

    @Override
    public void serialize(State state, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("value", state.getValue());
        jsonGenerator.writeStringField("name", state.getName());
        jsonGenerator.writeBooleanField("active", state.isActive());
        jsonGenerator.writeEndObject();
    }

}
