# 1. Creational Patterns

Date: 2019-02-02

## Status

Accepted

## Context

We want to have a common contract for the way that our specific solutions for each Day behave in the application context. For that, we will enforce the implementation of specific methods. In addition, we want to have an easy access to those specific implementations and will rely on Spring's application context.

## Decision

The Interface `Days.class` is part of an Abstract Factory for concrete Day classes. The instances for the specific Days are created and provided by the Spring context upon annotating the specific days with `@Component`, so it is not a real factory - just part of it. 

In the `AdventOfCodeService.class`, a `List<Days>`, which is populated by Spring with instances of the specific Days, is used by a factory method, or repository method if you want to name it that way in order to find the correct instance for a specific requested day.

## Consequences

Any new requirements to a Day must be passed on to every specific Day implementation.
