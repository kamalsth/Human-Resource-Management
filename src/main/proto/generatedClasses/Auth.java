// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Auth.proto

package generatedClasses;

public final class Auth {
  private Auth() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nAuth.proto\022\005proto\032\022LoginRequest.proto\032" +
      "\023LoginResponse.proto\032\025RegisterRequest.pr" +
      "oto\032\026RegisterResponse.proto2\202\001\n\013AuthServ" +
      "ice\0224\n\005Login\022\023.proto.LoginRequest\032\024.prot" +
      "o.LoginResponse\"\000\022=\n\010Register\022\026.proto.Re" +
      "gisterRequest\032\027.proto.RegisterResponse\"\000" +
      "B\022\n\020generatedClassesb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          generatedClasses.LoginRequestOuterClass.getDescriptor(),
          generatedClasses.LoginResponseOuterClass.getDescriptor(),
          generatedClasses.RegisterRequestOuterClass.getDescriptor(),
          generatedClasses.RegisterResponseOuterClass.getDescriptor(),
        });
    generatedClasses.LoginRequestOuterClass.getDescriptor();
    generatedClasses.LoginResponseOuterClass.getDescriptor();
    generatedClasses.RegisterRequestOuterClass.getDescriptor();
    generatedClasses.RegisterResponseOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}