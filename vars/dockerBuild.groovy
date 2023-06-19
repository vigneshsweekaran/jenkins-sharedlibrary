def call(String username) {
  docker.build(username + "/hello-world:${TAG}")
}
