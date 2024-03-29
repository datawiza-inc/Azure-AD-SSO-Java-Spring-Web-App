# Datawiza Training Module - Use Low-Code Datawiza to Build Java Spring Apps with Azure AD SSO

This module will introduce you to using No-Code Datwiza to build a Java Spring web application. It shows two major functionalities:

- How to enable Microsoft login (Microsoft Azure AD work or school account)
- How to pass user attributes to the application backend

## Online demo

We built an online demo based on this repo: https://spring-sso.datawiza.net. You can login via your Azure AD account or personal Microsoft account.

## The Benefits of Using No-Code Datawiza

- No need to learn complex OIDC/OAuth or SAML protocols
- No need to manage refresh tokens, access tokens or ID tokens
- No need to manage user sessions
- No need to use SDKs and write code
- Reduce weeks of engineering work to hours, even minutes
- Avoid security vulnerabilities with a No-Code product developed by security experts

## How No-Code Datawiza Works

![A diagram showing how datawiza works with Azure AD ](/img/how-datawiza-works.png)

Datawiza is deployed as a reverse proxy in front of web apps, talking to Azure AD. It authenticates users with Azure AD via OIDC or SAML and then passes the user info, access token and others to the app so that the app itself does not have to talk to Azure AD directly, maintain user sessions or manage tokens.

The Datawiza proxies are delivered as lightweight docker containers (supporting sidecar or standalone mode) and managed via a unified cloud console [(more details)](https://www.datawiza.com/platform/). It works with any environment and is a perfect fit for multi-clouds.

## Introduction

This repo is used to run a pre-configured [Datawiza Access Broker (DAB)](https://docs.datawiza.com/overview.html#what-is-datawiza-access-broker) with a web app that will read `username`, `email`, and `access token` from the request http headers to achieve Single Sign-On (SSO) without actually coding the authentication part. The Identity Provider used, is an Azure AD multi-tenant application, which means all users with a work or school account from Microsoft can log in.

## Run the Demo

You can run this demo simply with [docker compose](https://docs.docker.com/compose/) as follows. It will build the JAVA Spring app and run it together with DAB. 

```shell
docker-compose -f docker-compose.yaml up -d
```

Visit [http://localhost:9772](http://localhost:9772), after logging in to Azure AD successfully, you should see the username, email, and access token of your account:
![header-based app](/img/java/response.png)

We also provide a complete tutorial for you, which you can use to build your application in DCMC. You can see the guide [here](/demo/java/README.md) for more information.


## Support

If you run into any issues or would like to get help from Datawiza team, you can

- Schedule a [30-minutes meeting](https://calendly.com/datawiza/30min)
- Join [Datawiza Discord server](https://discord.com/invite/Sn3nbc83Up)
- Send an email to: [support@datawiza.com](mailto:support@datawiza.com)
