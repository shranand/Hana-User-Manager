# Hana-User-Manager
JDBC User Manager For Hana


UserMan – User Management Features

1.	Using CMD navigate to the folder containing the jar
2.	Execute the jar using java –jar userMan.jar
3.	Supply parameters following the jar call.

Parameter Sequence (Seperated by Spaces): 
<HanaHost> <HanaPort> <HanaUser> <HanaPwd> <Action: Create/ Delete/ Update> <UserName> <SAML Provider><UserIdentity> <Roles separated by commas like role1,role2,role3>

Example: 
java -jar userMan.jar hana01.dev.dci.local 30015 jaisebastian Welcome.1 create testUser1212 SAP_HANA_TEST_OPENSSO testIden1212 PUBLIC
java -jar userMan.jar hana01.dev.dci.local 30015 jaisebastian Welcome.1 delete testUser1212 SAP_HANA_TEST_OPENSSO testIden1212 PUBLIC
