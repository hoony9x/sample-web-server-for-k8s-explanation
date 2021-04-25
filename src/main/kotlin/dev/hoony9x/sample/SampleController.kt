package dev.hoony9x.sample

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class SampleController {
    @GetMapping("/api/hello")
    fun hello(): Map<String, String> {
        return mapOf(
            "message" to "Hello Everyone!",
            "version" to "1.0"
        )
    }
}