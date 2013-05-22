package com.lleggieri

/**
 * These auxiliary classes help building numbers like "one hundred thousand" or "two hundred million"
 * @param multiplier the number this auxiliary multiplies to.
 */
private[lleggieri] abstract sealed class Auxiliary(private[lleggieri] val multiplier: Long)

private[lleggieri] final class Thou extends Auxiliary(1000)

private[lleggieri] final class Mill extends Auxiliary(1000000)

