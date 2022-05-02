Small requirements tests for https://login.qt.io/register form.

Defects found:
1. Email verification doesn't check all special characters (test testErrorForIncorrectEmailAddress_shouldContainCorrectText()). 
The following list of emails is allowed from client side:
- "user!name@domain.com",
- "user*name@domain.com",
- "user&name@domain.com",
- "user?name@domain.com",
- "user+name@domain.com"
2. Password requirements contain the rule "Cannot contain your email address or name", but client side allows email to be used in password (test testErrorForPasswordEqualsToEmail_shouldContainCorrectText()).
