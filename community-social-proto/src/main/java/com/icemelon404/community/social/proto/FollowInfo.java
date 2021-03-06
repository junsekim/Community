// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: FollowCheckService.proto

package com.icemelon404.community.social.proto;

/**
 * Protobuf type {@code FollowInfo}
 */
public final class FollowInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:FollowInfo)
    FollowInfoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FollowInfo.newBuilder() to construct.
  private FollowInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FollowInfo() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new FollowInfo();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FollowInfo(
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
          case 8: {

            follower_ = input.readInt64();
            break;
          }
          case 16: {

            followee_ = input.readInt64();
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
    return com.icemelon404.community.social.proto.FollowCheckServiceOuterClass.internal_static_FollowInfo_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.icemelon404.community.social.proto.FollowCheckServiceOuterClass.internal_static_FollowInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.icemelon404.community.social.proto.FollowInfo.class, com.icemelon404.community.social.proto.FollowInfo.Builder.class);
  }

  public static final int FOLLOWER_FIELD_NUMBER = 1;
  private long follower_;
  /**
   * <code>int64 follower = 1;</code>
   * @return The follower.
   */
  @java.lang.Override
  public long getFollower() {
    return follower_;
  }

  public static final int FOLLOWEE_FIELD_NUMBER = 2;
  private long followee_;
  /**
   * <code>int64 followee = 2;</code>
   * @return The followee.
   */
  @java.lang.Override
  public long getFollowee() {
    return followee_;
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
    if (follower_ != 0L) {
      output.writeInt64(1, follower_);
    }
    if (followee_ != 0L) {
      output.writeInt64(2, followee_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (follower_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, follower_);
    }
    if (followee_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, followee_);
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
    if (!(obj instanceof com.icemelon404.community.social.proto.FollowInfo)) {
      return super.equals(obj);
    }
    com.icemelon404.community.social.proto.FollowInfo other = (com.icemelon404.community.social.proto.FollowInfo) obj;

    if (getFollower()
        != other.getFollower()) return false;
    if (getFollowee()
        != other.getFollowee()) return false;
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
    hash = (37 * hash) + FOLLOWER_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getFollower());
    hash = (37 * hash) + FOLLOWEE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getFollowee());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.icemelon404.community.social.proto.FollowInfo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.icemelon404.community.social.proto.FollowInfo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.icemelon404.community.social.proto.FollowInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.icemelon404.community.social.proto.FollowInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.icemelon404.community.social.proto.FollowInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.icemelon404.community.social.proto.FollowInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.icemelon404.community.social.proto.FollowInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.icemelon404.community.social.proto.FollowInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.icemelon404.community.social.proto.FollowInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.icemelon404.community.social.proto.FollowInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.icemelon404.community.social.proto.FollowInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.icemelon404.community.social.proto.FollowInfo parseFrom(
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
  public static Builder newBuilder(com.icemelon404.community.social.proto.FollowInfo prototype) {
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
   * Protobuf type {@code FollowInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:FollowInfo)
      com.icemelon404.community.social.proto.FollowInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.icemelon404.community.social.proto.FollowCheckServiceOuterClass.internal_static_FollowInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.icemelon404.community.social.proto.FollowCheckServiceOuterClass.internal_static_FollowInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.icemelon404.community.social.proto.FollowInfo.class, com.icemelon404.community.social.proto.FollowInfo.Builder.class);
    }

    // Construct using com.icemelon404.community.social.proto.FollowInfo.newBuilder()
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
      follower_ = 0L;

      followee_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.icemelon404.community.social.proto.FollowCheckServiceOuterClass.internal_static_FollowInfo_descriptor;
    }

    @java.lang.Override
    public com.icemelon404.community.social.proto.FollowInfo getDefaultInstanceForType() {
      return com.icemelon404.community.social.proto.FollowInfo.getDefaultInstance();
    }

    @java.lang.Override
    public com.icemelon404.community.social.proto.FollowInfo build() {
      com.icemelon404.community.social.proto.FollowInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.icemelon404.community.social.proto.FollowInfo buildPartial() {
      com.icemelon404.community.social.proto.FollowInfo result = new com.icemelon404.community.social.proto.FollowInfo(this);
      result.follower_ = follower_;
      result.followee_ = followee_;
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
      if (other instanceof com.icemelon404.community.social.proto.FollowInfo) {
        return mergeFrom((com.icemelon404.community.social.proto.FollowInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.icemelon404.community.social.proto.FollowInfo other) {
      if (other == com.icemelon404.community.social.proto.FollowInfo.getDefaultInstance()) return this;
      if (other.getFollower() != 0L) {
        setFollower(other.getFollower());
      }
      if (other.getFollowee() != 0L) {
        setFollowee(other.getFollowee());
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
      com.icemelon404.community.social.proto.FollowInfo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.icemelon404.community.social.proto.FollowInfo) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long follower_ ;
    /**
     * <code>int64 follower = 1;</code>
     * @return The follower.
     */
    @java.lang.Override
    public long getFollower() {
      return follower_;
    }
    /**
     * <code>int64 follower = 1;</code>
     * @param value The follower to set.
     * @return This builder for chaining.
     */
    public Builder setFollower(long value) {
      
      follower_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 follower = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearFollower() {
      
      follower_ = 0L;
      onChanged();
      return this;
    }

    private long followee_ ;
    /**
     * <code>int64 followee = 2;</code>
     * @return The followee.
     */
    @java.lang.Override
    public long getFollowee() {
      return followee_;
    }
    /**
     * <code>int64 followee = 2;</code>
     * @param value The followee to set.
     * @return This builder for chaining.
     */
    public Builder setFollowee(long value) {
      
      followee_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 followee = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearFollowee() {
      
      followee_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:FollowInfo)
  }

  // @@protoc_insertion_point(class_scope:FollowInfo)
  private static final com.icemelon404.community.social.proto.FollowInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.icemelon404.community.social.proto.FollowInfo();
  }

  public static com.icemelon404.community.social.proto.FollowInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FollowInfo>
      PARSER = new com.google.protobuf.AbstractParser<FollowInfo>() {
    @java.lang.Override
    public FollowInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new FollowInfo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FollowInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FollowInfo> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.icemelon404.community.social.proto.FollowInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

