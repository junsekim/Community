// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: FeedServiceProto.proto

package com.icemelon404.community.feed.proto;

/**
 * Protobuf type {@code FeedResponse}
 */
public final class FeedResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:FeedResponse)
    FeedResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FeedResponse.newBuilder() to construct.
  private FeedResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FeedResponse() {
    postId_ = emptyLongList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new FeedResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FeedResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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
          case 8: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              postId_ = newLongList();
              mutable_bitField0_ |= 0x00000001;
            }
            postId_.addLong(input.readInt64());
            break;
          }
          case 10: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000001) != 0) && input.getBytesUntilLimit() > 0) {
              postId_ = newLongList();
              mutable_bitField0_ |= 0x00000001;
            }
            while (input.getBytesUntilLimit() > 0) {
              postId_.addLong(input.readInt64());
            }
            input.popLimit(limit);
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        postId_.makeImmutable(); // C
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.icemelon404.community.feed.proto.FeedServiceProto.internal_static_FeedResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.icemelon404.community.feed.proto.FeedServiceProto.internal_static_FeedResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.icemelon404.community.feed.proto.FeedResponse.class, com.icemelon404.community.feed.proto.FeedResponse.Builder.class);
  }

  public static final int POSTID_FIELD_NUMBER = 1;
  private com.google.protobuf.Internal.LongList postId_;
  /**
   * <code>repeated int64 postId = 1 [packed = true];</code>
   * @return A list containing the postId.
   */
  @java.lang.Override
  public java.util.List<java.lang.Long>
      getPostIdList() {
    return postId_;
  }
  /**
   * <code>repeated int64 postId = 1 [packed = true];</code>
   * @return The count of postId.
   */
  public int getPostIdCount() {
    return postId_.size();
  }
  /**
   * <code>repeated int64 postId = 1 [packed = true];</code>
   * @param index The index of the element to return.
   * @return The postId at the given index.
   */
  public long getPostId(int index) {
    return postId_.getLong(index);
  }
  private int postIdMemoizedSerializedSize = -1;

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
    getSerializedSize();
    if (getPostIdList().size() > 0) {
      output.writeUInt32NoTag(10);
      output.writeUInt32NoTag(postIdMemoizedSerializedSize);
    }
    for (int i = 0; i < postId_.size(); i++) {
      output.writeInt64NoTag(postId_.getLong(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    {
      int dataSize = 0;
      for (int i = 0; i < postId_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt64SizeNoTag(postId_.getLong(i));
      }
      size += dataSize;
      if (!getPostIdList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      postIdMemoizedSerializedSize = dataSize;
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
    if (!(obj instanceof com.icemelon404.community.feed.proto.FeedResponse)) {
      return super.equals(obj);
    }
    com.icemelon404.community.feed.proto.FeedResponse other = (com.icemelon404.community.feed.proto.FeedResponse) obj;

    if (!getPostIdList()
        .equals(other.getPostIdList())) return false;
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
    if (getPostIdCount() > 0) {
      hash = (37 * hash) + POSTID_FIELD_NUMBER;
      hash = (53 * hash) + getPostIdList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.icemelon404.community.feed.proto.FeedResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.icemelon404.community.feed.proto.FeedResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.icemelon404.community.feed.proto.FeedResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.icemelon404.community.feed.proto.FeedResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.icemelon404.community.feed.proto.FeedResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.icemelon404.community.feed.proto.FeedResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.icemelon404.community.feed.proto.FeedResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.icemelon404.community.feed.proto.FeedResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.icemelon404.community.feed.proto.FeedResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.icemelon404.community.feed.proto.FeedResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.icemelon404.community.feed.proto.FeedResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.icemelon404.community.feed.proto.FeedResponse parseFrom(
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
  public static Builder newBuilder(com.icemelon404.community.feed.proto.FeedResponse prototype) {
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
   * Protobuf type {@code FeedResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:FeedResponse)
      com.icemelon404.community.feed.proto.FeedResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.icemelon404.community.feed.proto.FeedServiceProto.internal_static_FeedResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.icemelon404.community.feed.proto.FeedServiceProto.internal_static_FeedResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.icemelon404.community.feed.proto.FeedResponse.class, com.icemelon404.community.feed.proto.FeedResponse.Builder.class);
    }

    // Construct using com.icemelon404.community.feed.proto.FeedResponse.newBuilder()
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
      postId_ = emptyLongList();
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.icemelon404.community.feed.proto.FeedServiceProto.internal_static_FeedResponse_descriptor;
    }

    @java.lang.Override
    public com.icemelon404.community.feed.proto.FeedResponse getDefaultInstanceForType() {
      return com.icemelon404.community.feed.proto.FeedResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.icemelon404.community.feed.proto.FeedResponse build() {
      com.icemelon404.community.feed.proto.FeedResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.icemelon404.community.feed.proto.FeedResponse buildPartial() {
      com.icemelon404.community.feed.proto.FeedResponse result = new com.icemelon404.community.feed.proto.FeedResponse(this);
      int from_bitField0_ = bitField0_;
      if (((bitField0_ & 0x00000001) != 0)) {
        postId_.makeImmutable();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.postId_ = postId_;
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
      if (other instanceof com.icemelon404.community.feed.proto.FeedResponse) {
        return mergeFrom((com.icemelon404.community.feed.proto.FeedResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.icemelon404.community.feed.proto.FeedResponse other) {
      if (other == com.icemelon404.community.feed.proto.FeedResponse.getDefaultInstance()) return this;
      if (!other.postId_.isEmpty()) {
        if (postId_.isEmpty()) {
          postId_ = other.postId_;
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          ensurePostIdIsMutable();
          postId_.addAll(other.postId_);
        }
        onChanged();
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
      com.icemelon404.community.feed.proto.FeedResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.icemelon404.community.feed.proto.FeedResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private com.google.protobuf.Internal.LongList postId_ = emptyLongList();
    private void ensurePostIdIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        postId_ = mutableCopy(postId_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated int64 postId = 1 [packed = true];</code>
     * @return A list containing the postId.
     */
    public java.util.List<java.lang.Long>
        getPostIdList() {
      return ((bitField0_ & 0x00000001) != 0) ?
               java.util.Collections.unmodifiableList(postId_) : postId_;
    }
    /**
     * <code>repeated int64 postId = 1 [packed = true];</code>
     * @return The count of postId.
     */
    public int getPostIdCount() {
      return postId_.size();
    }
    /**
     * <code>repeated int64 postId = 1 [packed = true];</code>
     * @param index The index of the element to return.
     * @return The postId at the given index.
     */
    public long getPostId(int index) {
      return postId_.getLong(index);
    }
    /**
     * <code>repeated int64 postId = 1 [packed = true];</code>
     * @param index The index to set the value at.
     * @param value The postId to set.
     * @return This builder for chaining.
     */
    public Builder setPostId(
        int index, long value) {
      ensurePostIdIsMutable();
      postId_.setLong(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 postId = 1 [packed = true];</code>
     * @param value The postId to add.
     * @return This builder for chaining.
     */
    public Builder addPostId(long value) {
      ensurePostIdIsMutable();
      postId_.addLong(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 postId = 1 [packed = true];</code>
     * @param values The postId to add.
     * @return This builder for chaining.
     */
    public Builder addAllPostId(
        java.lang.Iterable<? extends java.lang.Long> values) {
      ensurePostIdIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, postId_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int64 postId = 1 [packed = true];</code>
     * @return This builder for chaining.
     */
    public Builder clearPostId() {
      postId_ = emptyLongList();
      bitField0_ = (bitField0_ & ~0x00000001);
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


    // @@protoc_insertion_point(builder_scope:FeedResponse)
  }

  // @@protoc_insertion_point(class_scope:FeedResponse)
  private static final com.icemelon404.community.feed.proto.FeedResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.icemelon404.community.feed.proto.FeedResponse();
  }

  public static com.icemelon404.community.feed.proto.FeedResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FeedResponse>
      PARSER = new com.google.protobuf.AbstractParser<FeedResponse>() {
    @java.lang.Override
    public FeedResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new FeedResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FeedResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FeedResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.icemelon404.community.feed.proto.FeedResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

