pipelineJob('EasyClaimFrontend') {
    triggers {
        scm('* * * * *')
    }
    
    definition {
        cps {
            script(readFileFromWorkspace('pipeline/frontend-jenkinsfile'))
            sandbox()
        }
    }
}
