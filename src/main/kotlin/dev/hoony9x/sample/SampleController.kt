package dev.hoony9x.sample

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/")
class SampleController{
    private val log: Logger = LoggerFactory.getLogger(SampleController::class.java)

    @GetMapping("/api/hello")
    fun hello(request: HttpServletRequest, @RequestHeader headers: Map<String, String>): Map<String, String> {
        log.info(mapOf(
            "remote_ip" to request.remoteAddr,
            "path" to request.requestURI,
            "method" to request.method,
            "headers" to headers,
            "queries" to request.queryString
        ).toString())

        return mapOf(
            "message" to "Hello Everyone!",
            "version" to "1.0"
        )
    }
}