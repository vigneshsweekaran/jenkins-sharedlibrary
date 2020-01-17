pipelineJob('EasyClaimFrontend') {

    description('EasyClaimFrontend application developed in Angular 7')

    triggers {
        scm('* * * * *')
    }

    definition {
        cpsScm {
            lightweight(true)
            scm{
                git {
                    branch('master')
                    remote{
                        url('https://github.com/vigneshsweekaran/capstone-easyclaim-frontend.git')
                        credentials('git_credential')
                    }
                    extensions { }
                }
            }
            scriptPath('frontend-jenkinsfile')
        }
    }
}
