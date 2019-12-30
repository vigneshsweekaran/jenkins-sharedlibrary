pipelineJob('EasyClaimFrontend') {
    definition {
        cps {
            script(readFileFromWorkspace('pipeline/frontend-jenkinsfile'))
            sandbox()
        }
    }
}
