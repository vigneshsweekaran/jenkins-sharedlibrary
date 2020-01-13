pipelineJob('EasyClaimBackend') {
    description('EasyClaimBackend')
    definition {
        cpsScm {
            lightweight(true)
            scm{
                git {
                    branch('master')
                    remote{
                        url('https://github.com/vigneshsweekaran/jenkins-library.git')
                    }
                    extensions { }
                }
            }
            scriptPath('pipeline/backend-jenkinsfile')
        }
    }
}
