// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RegisterRequest.proto

package generatedClasses;

public final class RegisterRequestOuterClass {
  private RegisterRequestOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface RegisterRequestOrBuilder extends
      // @@protoc_insertion_point(interface_extends:proto.RegisterRequest)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.proto.User user = 1;</code>
     * @return Whether the user field is set.
     */
    boolean hasUser();
    /**
     * <code>.proto.User user = 1;</code>
     * @return The user.
     */
    generatedClasses.UserOuterClass.User getUser();
    /**
     * <code>.proto.User user = 1;</code>
     */
    generatedClasses.UserOuterClass.UserOrBuilder getUserOrBuilder();
  }
  /**
   * Protobuf type {@code proto.RegisterRequest}
   */
  public static final class RegisterRequest extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:proto.RegisterRequest)
      RegisterRequestOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use RegisterRequest.newBuilder() to construct.
    private RegisterRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private RegisterRequest() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new RegisterRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private RegisterRequest(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              generatedClasses.UserOuterClass.User.Builder subBuilder = null;
              if (user_ != null) {
                subBuilder = user_.toBuilder();
              }
              user_ = input.readMessage(generatedClasses.UserOuterClass.User.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(user_);
                user_ = subBuilder.buildPartial();
              }

              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return generatedClasses.RegisterRequestOuterClass.internal_static_proto_RegisterRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return generatedClasses.RegisterRequestOuterClass.internal_static_proto_RegisterRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              generatedClasses.RegisterRequestOuterClass.RegisterRequest.class, generatedClasses.RegisterRequestOuterClass.RegisterRequest.Builder.class);
    }

    public static final int USER_FIELD_NUMBER = 1;
    private generatedClasses.UserOuterClass.User user_;
    /**
     * <code>.proto.User user = 1;</code>
     * @return Whether the user field is set.
     */
    @java.lang.Override
    public boolean hasUser() {
      return user_ != null;
    }
    /**
     * <code>.proto.User user = 1;</code>
     * @return The user.
     */
    @java.lang.Override
    public generatedClasses.UserOuterClass.User getUser() {
      return user_ == null ? generatedClasses.UserOuterClass.User.getDefaultInstance() : user_;
    }
    /**
     * <code>.proto.User user = 1;</code>
     */
    @java.lang.Override
    public generatedClasses.UserOuterClass.UserOrBuilder getUserOrBuilder() {
      return getUser();
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
      if (user_ != null) {
        output.writeMessage(1, getUser());
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (user_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, getUser());
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof generatedClasses.RegisterRequestOuterClass.RegisterRequest)) {
        return super.equals(obj);
      }
      generatedClasses.RegisterRequestOuterClass.RegisterRequest other = (generatedClasses.RegisterRequestOuterClass.RegisterRequest) obj;

      if (hasUser() != other.hasUser()) return false;
      if (hasUser()) {
        if (!getUser()
            .equals(other.getUser())) return false;
      }
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (hasUser()) {
        hash = (37 * hash) + USER_FIELD_NUMBER;
        hash = (53 * hash) + getUser().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static generatedClasses.RegisterRequestOuterClass.RegisterRequest parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static generatedClasses.RegisterRequestOuterClass.RegisterRequest parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static generatedClasses.RegisterRequestOuterClass.RegisterRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static generatedClasses.RegisterRequestOuterClass.RegisterRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static generatedClasses.RegisterRequestOuterClass.RegisterRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static generatedClasses.RegisterRequestOuterClass.RegisterRequest parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static generatedClasses.RegisterRequestOuterClass.RegisterRequest parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static generatedClasses.RegisterRequestOuterClass.RegisterRequest parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static generatedClasses.RegisterRequestOuterClass.RegisterRequest parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static generatedClasses.RegisterRequestOuterClass.RegisterRequest parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static generatedClasses.RegisterRequestOuterClass.RegisterRequest parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static generatedClasses.RegisterRequestOuterClass.RegisterRequest parseFrom(
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
    public static Builder newBuilder(generatedClasses.RegisterRequestOuterClass.RegisterRequest prototype) {
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
     * Protobuf type {@code proto.RegisterRequest}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:proto.RegisterRequest)
        generatedClasses.RegisterRequestOuterClass.RegisterRequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return generatedClasses.RegisterRequestOuterClass.internal_static_proto_RegisterRequest_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return generatedClasses.RegisterRequestOuterClass.internal_static_proto_RegisterRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                generatedClasses.RegisterRequestOuterClass.RegisterRequest.class, generatedClasses.RegisterRequestOuterClass.RegisterRequest.Builder.class);
      }

      // Construct using generatedClasses.RegisterRequestOuterClass.RegisterRequest.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        if (userBuilder_ == null) {
          user_ = null;
        } else {
          user_ = null;
          userBuilder_ = null;
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return generatedClasses.RegisterRequestOuterClass.internal_static_proto_RegisterRequest_descriptor;
      }

      @java.lang.Override
      public generatedClasses.RegisterRequestOuterClass.RegisterRequest getDefaultInstanceForType() {
        return generatedClasses.RegisterRequestOuterClass.RegisterRequest.getDefaultInstance();
      }

      @java.lang.Override
      public generatedClasses.RegisterRequestOuterClass.RegisterRequest build() {
        generatedClasses.RegisterRequestOuterClass.RegisterRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public generatedClasses.RegisterRequestOuterClass.RegisterRequest buildPartial() {
        generatedClasses.RegisterRequestOuterClass.RegisterRequest result = new generatedClasses.RegisterRequestOuterClass.RegisterRequest(this);
        if (userBuilder_ == null) {
          result.user_ = user_;
        } else {
          result.user_ = userBuilder_.build();
        }
        onBuilt();
        return result;
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
        if (other instanceof generatedClasses.RegisterRequestOuterClass.RegisterRequest) {
          return mergeFrom((generatedClasses.RegisterRequestOuterClass.RegisterRequest)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(generatedClasses.RegisterRequestOuterClass.RegisterRequest other) {
        if (other == generatedClasses.RegisterRequestOuterClass.RegisterRequest.getDefaultInstance()) return this;
        if (other.hasUser()) {
          mergeUser(other.getUser());
        }
        this.mergeUnknownFields(other.unknownFields);
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
        generatedClasses.RegisterRequestOuterClass.RegisterRequest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (generatedClasses.RegisterRequestOuterClass.RegisterRequest) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private generatedClasses.UserOuterClass.User user_;
      private com.google.protobuf.SingleFieldBuilderV3<
          generatedClasses.UserOuterClass.User, generatedClasses.UserOuterClass.User.Builder, generatedClasses.UserOuterClass.UserOrBuilder> userBuilder_;
      /**
       * <code>.proto.User user = 1;</code>
       * @return Whether the user field is set.
       */
      public boolean hasUser() {
        return userBuilder_ != null || user_ != null;
      }
      /**
       * <code>.proto.User user = 1;</code>
       * @return The user.
       */
      public generatedClasses.UserOuterClass.User getUser() {
        if (userBuilder_ == null) {
          return user_ == null ? generatedClasses.UserOuterClass.User.getDefaultInstance() : user_;
        } else {
          return userBuilder_.getMessage();
        }
      }
      /**
       * <code>.proto.User user = 1;</code>
       */
      public Builder setUser(generatedClasses.UserOuterClass.User value) {
        if (userBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          user_ = value;
          onChanged();
        } else {
          userBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>.proto.User user = 1;</code>
       */
      public Builder setUser(
          generatedClasses.UserOuterClass.User.Builder builderForValue) {
        if (userBuilder_ == null) {
          user_ = builderForValue.build();
          onChanged();
        } else {
          userBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>.proto.User user = 1;</code>
       */
      public Builder mergeUser(generatedClasses.UserOuterClass.User value) {
        if (userBuilder_ == null) {
          if (user_ != null) {
            user_ =
              generatedClasses.UserOuterClass.User.newBuilder(user_).mergeFrom(value).buildPartial();
          } else {
            user_ = value;
          }
          onChanged();
        } else {
          userBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>.proto.User user = 1;</code>
       */
      public Builder clearUser() {
        if (userBuilder_ == null) {
          user_ = null;
          onChanged();
        } else {
          user_ = null;
          userBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>.proto.User user = 1;</code>
       */
      public generatedClasses.UserOuterClass.User.Builder getUserBuilder() {
        
        onChanged();
        return getUserFieldBuilder().getBuilder();
      }
      /**
       * <code>.proto.User user = 1;</code>
       */
      public generatedClasses.UserOuterClass.UserOrBuilder getUserOrBuilder() {
        if (userBuilder_ != null) {
          return userBuilder_.getMessageOrBuilder();
        } else {
          return user_ == null ?
              generatedClasses.UserOuterClass.User.getDefaultInstance() : user_;
        }
      }
      /**
       * <code>.proto.User user = 1;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          generatedClasses.UserOuterClass.User, generatedClasses.UserOuterClass.User.Builder, generatedClasses.UserOuterClass.UserOrBuilder> 
          getUserFieldBuilder() {
        if (userBuilder_ == null) {
          userBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              generatedClasses.UserOuterClass.User, generatedClasses.UserOuterClass.User.Builder, generatedClasses.UserOuterClass.UserOrBuilder>(
                  getUser(),
                  getParentForChildren(),
                  isClean());
          user_ = null;
        }
        return userBuilder_;
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


      // @@protoc_insertion_point(builder_scope:proto.RegisterRequest)
    }

    // @@protoc_insertion_point(class_scope:proto.RegisterRequest)
    private static final generatedClasses.RegisterRequestOuterClass.RegisterRequest DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new generatedClasses.RegisterRequestOuterClass.RegisterRequest();
    }

    public static generatedClasses.RegisterRequestOuterClass.RegisterRequest getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<RegisterRequest>
        PARSER = new com.google.protobuf.AbstractParser<RegisterRequest>() {
      @java.lang.Override
      public RegisterRequest parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new RegisterRequest(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<RegisterRequest> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<RegisterRequest> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public generatedClasses.RegisterRequestOuterClass.RegisterRequest getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_RegisterRequest_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_RegisterRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025RegisterRequest.proto\022\005proto\032\nUser.pro" +
      "to\",\n\017RegisterRequest\022\031\n\004user\030\001 \001(\0132\013.pr" +
      "oto.UserB\022\n\020generatedClassesb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          generatedClasses.UserOuterClass.getDescriptor(),
        });
    internal_static_proto_RegisterRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_proto_RegisterRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_RegisterRequest_descriptor,
        new java.lang.String[] { "User", });
    generatedClasses.UserOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
