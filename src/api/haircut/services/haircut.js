'use strict';

/**
 * haircut service.
 */

const { createCoreService } = require('@strapi/strapi').factories;

module.exports = createCoreService('api::haircut.haircut');
