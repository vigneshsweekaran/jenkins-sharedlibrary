def call(String dockerRegistryName = 'Dockerhub') {

    if (dockerRegistryName == "Dockerhub") {}
        docker.build("vigneshsweekaran/hello-world:${TAG}")
        docker.withRegistry("https://registry.hub.docker.com", 'docker_credential') {
            docker.image("vigneshsweekaran/hello-world:${TAG}").push()
            docker.image("vigneshsweekaran/hello-world:${TAG}").push("latest")
    } elseif (dockerRegistryName == "JfrogArtifactory") {
        docker.build("default-docker-local/hello-world:${TAG}")
        docker.withRegistry('https://vigneshsweekaran.jfrog.io', 'artifactory-credential') {
            docker.image("default-docker-local/hello-world:${TAG}").push()
            docker.image("default-docker-local/hello-world:${TAG}").push("latest")
        }
    }
}