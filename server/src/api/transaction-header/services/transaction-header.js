'use strict';

/**
 * transaction-header service.
 */

const { createCoreService } = require('@strapi/strapi').factories;

module.exports = createCoreService('api::transaction-header.transaction-header');
