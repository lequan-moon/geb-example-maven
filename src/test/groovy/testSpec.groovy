import geb.spock.GebReportingSpec

import spock.lang.*

@Stepwise
class testSpec extends GebReportingSpec{
		def "go to test page"(){
			when:
			go("file:///home/leminhquan/Github/geb-example-maven/test.html")
			then:
			title == "leminhquan test"
		}
		
		def "test alert"(){
			when:
			go("file:///home/leminhquan/Github/geb-example-maven/test.html")
			then:
			waitFor{ $("#btnOK").displayed }
			withAlert{ $("#btnOK").click() } == "OK"
		}
		
		def "test form"(){
			when: // spock
			go("file:///home/leminhquan/Github/geb-example-maven/test.html") //geb
			then: //spock
			// geb
			$("#username").value("leminhquan")
			$("#password").value("leminhquanpass")
			withAlert{ $("#btnOK").click() } == "OK"
			testmethod()
			js.user == ['name' : "leminhquan", 'password' : "leminhquanpass"]
		}

		def "test method"(){
			println "test string"
		}
}
