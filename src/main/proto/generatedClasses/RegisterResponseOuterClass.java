// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RegisterResponse.proto

// Protobuf Java Version: 3.25.1
package generatedClasses;

public final class RegisterResponseOuterClass {
  private RegisterResponseOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface RegisterResponseOrBuilder extends
      // @@protoc_insertion_point(interface_extends:proto.RegisterResponse)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string status = 1;</code>
     * @return The status.
     */
    java.lang.String getStatus();
    /**
     * <code>string status = 1;</code>
     * @return The bytes for status.
     */
    com.google.protobuf.ByteString
        getStatusBytes();
  }
  /**
   * Protobuf type {@code proto.RegisterResponse}
   */
  public static final class RegisterResponse extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:proto.RegisterResponse)
      RegisterResponseOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use RegisterResponse.newBuilder() to construct.
    private RegisterResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private RegisterResponse() {
      status_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new RegisterResponse();
    }

    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return generatedClasses.RegisterResponseOuterClass.internal_static_proto_RegisterResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return generatedClasses.RegisterResponseOuterClass.internal_static_proto_RegisterResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              generatedClasses.RegisterResponseOuterClass.RegisterResponse.class, generatedClasses.RegisterResponseOuterClass.RegisterResponse.Builder.class);
    }

    public static final int STATUS_FIELD_NUMBER = 1;
    @SuppressWarnings("serial")
    private volatile java.lang.Object status_ = "";
    /**
     * <code>string status = 1;</code>
     * @return The status.
     */
    @java.lang.Override
    public java.lang.String getStatus() {
      java.lang.Object ref = status_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        status_ = s;
        return s;
      }
    }
    /**
     * <code>string status = 1;</code>
     * @return The bytes for status.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getStatusBytes() {
      java.lang.Object ref = status_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        status_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(status_)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, status_);
      }
      getUnknownFields().writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(status_)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, status_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof generatedClasses.RegisterResponseOuterClass.RegisterResponse)) {
        return super.equals(obj);
      }
      generatedClasses.RegisterResponseOuterClass.RegisterResponse other = (generatedClasses.RegisterResponseOuterClass.RegisterResponse) obj;

      if (!getStatus()
          .equals(other.getStatus())) return false;
      if (!getUnknownFields().equals(other.getUnknownFields())) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + STATUS_FIELD_NUMBER;
      hash = (53 * hash) + getStatus().hashCode();
      hash = (29 * hash) + getUnknownFields().hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static generatedClasses.RegisterResponseOuterClass.RegisterResponse parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static generatedClasses.RegisterResponseOuterClass.RegisterResponse parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static generatedClasses.RegisterResponseOuterClass.RegisterResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static generatedClasses.RegisterResponseOuterClass.RegisterResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static generatedClasses.RegisterResponseOuterClass.RegisterResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static generatedClasses.RegisterResponseOuterClass.RegisterResponse parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static generatedClasses.RegisterResponseOuterClass.RegisterResponse parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static generatedClasses.RegisterResponseOuterClass.RegisterResponse parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static generatedClasses.RegisterResponseOuterClass.RegisterResponse parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }

    public static generatedClasses.RegisterResponseOuterClass.RegisterResponse parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static generatedClasses.RegisterResponseOuterClass.RegisterResponse parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static generatedClasses.RegisterResponseOuterClass.RegisterResponse parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(generatedClasses.RegisterResponseOuterClass.RegisterResponse prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code proto.RegisterResponse}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:proto.RegisterResponse)
        generatedClasses.RegisterResponseOuterClass.RegisterResponseOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return generatedClasses.RegisterResponseOuterClass.internal_static_proto_RegisterResponse_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return generatedClasses.RegisterResponseOuterClass.internal_static_proto_RegisterResponse_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                generatedClasses.RegisterResponseOuterClass.RegisterResponse.class, generatedClasses.RegisterResponseOuterClass.RegisterResponse.Builder.class);
      }

      // Construct using generatedClasses.RegisterResponseOuterClass.RegisterResponse.newBuilder()
      private Builder() {

      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);

      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        bitField0_ = 0;
        status_ = "";
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return generatedClasses.RegisterResponseOuterClass.internal_static_proto_RegisterResponse_descriptor;
      }

      @java.lang.Override
      public generatedClasses.RegisterResponseOuterClass.RegisterResponse getDefaultInstanceForType() {
        return generatedClasses.RegisterResponseOuterClass.RegisterResponse.getDefaultInstance();
      }

      @java.lang.Override
      public generatedClasses.RegisterResponseOuterClass.RegisterResponse build() {
        generatedClasses.RegisterResponseOuterClass.RegisterResponse result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public generatedClasses.RegisterResponseOuterClass.RegisterResponse buildPartial() {
        generatedClasses.RegisterResponseOuterClass.RegisterResponse result = new generatedClasses.RegisterResponseOuterClass.RegisterResponse(this);
        if (bitField0_ != 0) { buildPartial0(result); }
        onBuilt();
        return result;
      }

      private void buildPartial0(generatedClasses.RegisterResponseOuterClass.RegisterResponse result) {
        int from_bitField0_ = bitField0_;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          result.status_ = status_;
        }
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof generatedClasses.RegisterResponseOuterClass.RegisterResponse) {
          return mergeFrom((generatedClasses.RegisterResponseOuterClass.RegisterResponse)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(generatedClasses.RegisterResponseOuterClass.RegisterResponse other) {
        if (other == generatedClasses.RegisterResponseOuterClass.RegisterResponse.getDefaultInstance()) return this;
        if (!other.getStatus().isEmpty()) {
          status_ = other.status_;
          bitField0_ |= 0x00000001;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        if (extensionRegistry == null) {
          throw new java.lang.NullPointerException();
        }
        try {
          boolean done = false;
          while (!done) {
            int tag = input.readTag();
            switch (tag) {
              case 0:
                done = true;
                break;
              case 10: {
                status_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000001;
                break;
              } // case 10
              default: {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
            } // switch (tag)
          } // while (!done)
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.unwrapIOException();
        } finally {
          onChanged();
        } // finally
        return this;
      }
      private int bitField0_;

      private java.lang.Object status_ = "";
      /**
       * <code>string status = 1;</code>
       * @return The status.
       */
      public java.lang.String getStatus() {
        java.lang.Object ref = status_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          status_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string status = 1;</code>
       * @return The bytes for status.
       */
      public com.google.protobuf.ByteString
          getStatusBytes() {
        java.lang.Object ref = status_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          status_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string status = 1;</code>
       * @param value The status to set.
       * @return This builder for chaining.
       */
      public Builder setStatus(
          java.lang.String value) {
        if (value == null) { throw new NullPointerException(); }
        status_ = value;
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }
      /**
       * <code>string status = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearStatus() {
        status_ = getDefaultInstance().getStatus();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
        return this;
      }
      /**
       * <code>string status = 1;</code>
       * @param value The bytes for status to set.
       * @return This builder for chaining.
       */
      public Builder setStatusBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) { throw new NullPointerException(); }
        checkByteStringIsUtf8(value);
        status_ = value;
        bitField0_ |= 0x00000001;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:proto.RegisterResponse)
    }

    // @@protoc_insertion_point(class_scope:proto.RegisterResponse)
    private static final generatedClasses.RegisterResponseOuterClass.RegisterResponse DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new generatedClasses.RegisterResponseOuterClass.RegisterResponse();
    }

    public static generatedClasses.RegisterResponseOuterClass.RegisterResponse getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<RegisterResponse>
        PARSER = new com.google.protobuf.AbstractParser<RegisterResponse>() {
      @java.lang.Override
      public RegisterResponse parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        Builder builder = newBuilder();
        try {
          builder.mergeFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          throw e.setUnfinishedMessage(builder.buildPartial());
        } catch (com.google.protobuf.UninitializedMessageException e) {
          throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
        } catch (java.io.IOException e) {
          throw new com.google.protobuf.InvalidProtocolBufferException(e)
              .setUnfinishedMessage(builder.buildPartial());
        }
        return builder.buildPartial();
      }
    };

    public static com.google.protobuf.Parser<RegisterResponse> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<RegisterResponse> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public generatedClasses.RegisterResponseOuterClass.RegisterResponse getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_RegisterResponse_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_RegisterResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026RegisterResponse.proto\022\005proto\"\"\n\020Regis" +
      "terResponse\022\016\n\006status\030\001 \001(\tB\022\n\020generated" +
      "Classesb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_proto_RegisterResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_proto_RegisterResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_RegisterResponse_descriptor,
        new java.lang.String[] { "Status", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
