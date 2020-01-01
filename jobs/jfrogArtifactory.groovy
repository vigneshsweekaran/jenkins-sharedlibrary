job('JFrogArtifactory') {
    description "Setup the Jfrog artifactory as docker container in master node"
    label('master')
    steps {
        shell "sudo mkdir -p /data/jfrog/artifactory || true"
        shell "sudo useradd -u 1030 artifactory || true"
        shell "sudo chown -R artifactory /data || true"
        shell "docker stop artifactory || true"
        shell "docker rm artifactory || true"
        shell "docker run --name artifactory -d -p 8081:8081 \
            -v /data/jfrog/artifactory:/var/opt/jfrog/artifactory \
            -e EXTRA_JAVA_OPTIONS='-Xms512m -Xmx1g -Xss256k -XX:+UseG1GC' \
            docker.bintray.io/jfrog/artifactory-pro:latest"
    }
}
