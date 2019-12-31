pipelineJob('JFrogArtifactory') {
    definition {
        cps {
            script(readFileFromWorkspace('pipeline/jfrogArtifactory-jenkinsfile'))
            sandbox()
        }
    }
}
