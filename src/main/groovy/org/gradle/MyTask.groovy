package org.gradle

import tool.financial.crowl.RegisterCSVData
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class MyTask extends DefaultTask {
    String greeting = 'hello from GreetingTask'
    String trigger  = 'start'
    RegisterCSVData gs = new RegisterCSVData()

    @TaskAction
    def greet() {
        println greeting
    }

    @TaskAction
    def gather() {
        println trigger
        gs.main()
    }

}