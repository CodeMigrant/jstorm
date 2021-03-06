/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package backtype.storm.serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.nio.ByteBuffer;

/**
 * @author Cody (weiyue.wy@alibaba-inc.com)
 * @since 2.1.1
 */
public class KryoByteBufferSerializer extends Serializer<ByteBuffer> {

    @Override
    public void write(Kryo kryo, Output output, ByteBuffer object) {
        output.writeInt(object.array().length);
        output.write(object.array());
    }

    @Override
    public ByteBuffer read(Kryo kryo, Input input, Class<ByteBuffer> type) {
        int len = input.readInt();
        return ByteBuffer.wrap(input.readBytes(len));
    }
}
