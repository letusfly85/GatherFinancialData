package org.gradle

import tool.financial.crowl.GatherCSVData
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class MyTask extends DefaultTask {
    String greeting = 'hello from GreetingTask'
    String trigger  = 'start'
    GatherCSVData gs = new GatherCSVData()

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