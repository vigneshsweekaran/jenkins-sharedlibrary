Job('JFrogArtifactory') {
    description "Builds MyProject from master branch."
    label('master')
    steps {
        shell "docker run --name artifactory -d -p 8081:8081 \
            -v /data/jfrog/artifactory:/var/opt/jfrog/artifactory \
            -e EXTRA_JAVA_OPTIONS='-Xms512m -Xmx1g -Xss256k -XX:+UseG1GC' \
            docker.bintray.io/jfrog/artifactory-cpp-ce:latest"
    }
}
