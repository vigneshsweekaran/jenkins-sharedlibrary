pipelineJob('EasyClaimBackend') {
    triggers {
        scm('* * * * *')
    }
    
    definition {
        cps {
            script(readFileFromWorkspace('pipeline/backend-jenkinsfile'))
            sandbox()
        }
    }
}
