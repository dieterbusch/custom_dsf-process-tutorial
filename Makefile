HOST=https://dic/fhir/
CERT=./test-data-generator/cert/dic-client/dic-client_certificate.pem
PK=./test-data-generator/cert/dic-client/dic-client_private-key.pem
CERT_PW=password
HEADER_JSON=application/fhir+json;q=1.0
HEADER_XML=application/fhir+xml;charset=utf-8

FILE?=TODO_DEFINE_FILE_VAR:(make%post_t%FILE=<FILE>)

get_t:
	curl --cert $(CERT):$(CERT_PW) --key $(PK) -H "Accept: $(HEADER_JSON)" $(HOST)Task?_pretty=true --insecure

post_t:
	curl -X POST --cert $(CERT):$(CERT_PW)  --key $(PK) -H "Content-Type: $(HEADER_XML)"  -d @$(FILE) $(HOST)Task?_pretty=true --insecure

