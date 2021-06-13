def call(String dockerRegistryName = 'Dockerhub') {

    if (dockerRegistryName == "Dockerhub") {
        docker.build("vigneshsweekaran/hello-world:${TAG}")

        println("Publishing docker images to $dockerRegistryName")

        docker.withRegistry("https://registry.hub.docker.com", 'docker_credential') {
            docker.image("vigneshsweekaran/hello-world:${TAG}").push()
            docker.image("vigneshsweekaran/hello-world:${TAG}").push("latest")
    } else if (dockerRegistryName == "JfrogArtifactory") {
        docker.build("default-docker-local/hello-world:${TAG}")

        println("Publishing docker images to $dockerRegistryName")

        docker.withRegistry('https://vigneshsweekaran.jfrog.io', 'artifactory-credential') {
            docker.image("default-docker-local/hello-world:${TAG}").push()
            docker.image("default-docker-local/hello-world:${TAG}").push("latest")
        }
    }
}